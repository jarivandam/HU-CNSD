import json
import boto3
import os
import sys
import uuid



s3_client = boto3.client('s3')


def lambda_handler(event, context):
    for record in event['Records']:
       print ("test")
       payload = record["body"]
       body = json.loads(payload)[1]
       print("S3BucketName: ",body['s3BucketName'])
       print("s3Key: ",body['s3Key'])
       
       bucket = body['s3BucketName']
       key = body['s3Key']
       
       tmpkey = key.replace('/', '')
       download_path = '/tmp/{}{}'.format(uuid.uuid4(), tmpkey)
       s3_client.download_file(bucket, key, download_path)
       
       s3_client.upload_file(download_path, "sqs-resized-image-store", key)
       
       s3_client.delete_object(Bucket=bucket, Key=key)
    return {
        'statusCode': 200,
        'body': json.dumps(event)
    }