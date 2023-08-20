![alt text](/sc.png)

## About
A rest api with different endpoints hosted on aws lambda & api gateway using java.

## Endpoints
    1. GET /products
    2. GET /products/{id}
    3. GET /products/categories

## Test
```bash
mvn test
```

## How to deploy ?
1. Go to your aws account
2. Search for Lambda and click it
3. Create your lambda && ```Resources```  & their methods.
4. Connect your aws Lambda Function to your Api Gateway.
5. Click deploy.
6. run ```mvn clean package```
7. Upload your jar to lambda
8. Test in postman !!!

Give it a star ⭐ if you like it.