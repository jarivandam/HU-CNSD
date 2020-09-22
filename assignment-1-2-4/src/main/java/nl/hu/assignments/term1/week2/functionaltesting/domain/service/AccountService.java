package nl.hu.assignments.term1.week2.functionaltesting.domain.service;

import lombok.RequiredArgsConstructor;
import nl.hu.assignments.term1.week2.functionaltesting.data.entity.Account;
import nl.hu.assignments.term1.week2.functionaltesting.data.entity.Holder;
import nl.hu.assignments.term1.week2.functionaltesting.data.repository.AccountRepository;
import nl.hu.assignments.term1.week2.functionaltesting.data.repository.HolderRepository;
import nl.hu.assignments.term1.week2.functionaltesting.domain.exception.*;
import nl.hu.assignments.term1.week2.functionaltesting.web.dto.AccountDto;
import org.iban4j.Iban;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final HolderRepository holderRepository;

    public Page<Account> findAll(Pageable page) {
        return accountRepository.findAll(page);
    }

    public Account save(Account accountToSave) {
        return accountRepository.save(accountToSave);
    }

    public Account update(Iban iban, AccountDto accountDto) throws AccountNotFoundException, AccountAlreadyBlockedException {
        var account = this.getAccountFromIban(iban);

        var tryingToBlockAlreadyBlockedAccount = !account.isActive() && !accountDto.isActive();
        if (tryingToBlockAlreadyBlockedAccount) {
            throw new AccountAlreadyBlockedException(iban);
        }

        account = account.toBuilder()
                .active(accountDto.isActive())
                .build();

        return accountRepository.save(account);
    }

    public List<Holder> findAllHoldersByIban(Iban iban) {
        return holderRepository.findAllByAccountIban(iban);
    }

    public Account addHolder(Iban iban, Holder holder) throws AccountNotFoundException, AccountBlockedException {
        var account = this.getAccountFromIban(iban);

        if (!account.isActive()) {
            throw new AccountBlockedException(iban);
        }

        account.addAccountHolder(holder);

        return accountRepository.save(account);
    }

    public Account removeHolder(Iban accountIban, Holder holder) throws AccountNotFoundException {
        final var account = this.getAccountFromIban(accountIban);

        account.removeAccountHolder(holder.getId());

        return accountRepository.save(account);
    }

    private Account getAccountFromIban(Iban iban) throws AccountNotFoundException {
        final var optionalAccount = accountRepository.findByIban(iban);
        return optionalAccount.orElseThrow(() -> new AccountNotFoundException(iban));
    }

}
