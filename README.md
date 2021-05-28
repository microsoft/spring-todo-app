# Spring Todo App

This Spring TODO app is a Java application
built using [Spring Boot](https://spring.io/projects/spring-boot), 
[Spring Data for 
Cosmos DB](https://docs.microsoft.com/en-us/java/azure/spring-framework/configure-spring-boot-starter-java-app-with-cosmos-db?view=azure-java-stable) and 
[Azure Cosmos DB](https://docs.microsoft.com/en-us/azure/cosmos-db/sql-api-introduction). 

## Requirements

| [Azure CLI](http://docs.microsoft.com/cli/azure/overview) | [Java 8](https://www.azul.com/downloads/azure-only/zulu) | [Maven 3](http://maven.apache.org/) | [Git](https://github.com/) |

## Create Azure Cosmos DB

Create Azure Cosmos DB 
using [Azure CLI 2.0](https://docs.microsoft.com/en-us/cli/azure/install-azure-cli?view=azure-cli-latest) 

### STEP A - LOGIN to Azure
Login your Azure CLI, and set your subscription 
    
```bash
az login
az account set -s <your-subscription-id>
```
### STEP B - Create Resource Group

Create an Azure Resource Group, and note down the resource group name

```bash
az group create -n <your-azure-group-name> \
    -l <your-resource-group-region>
```

### STEP C - Create COSMOS DB

Create Azure Cosmos DB with GlobalDocumentDB kind. 
The name of Cosmos DB must use only lower case letters. Note down the `documentEndpoint` field in the response

```bash
az cosmosdb create --kind GlobalDocumentDB \
    -g <your-azure-group-name> \
    -n <your-azure-COSMOS-DB-name-in-lower-case-letters>
```

### STEP D - Get COSMOS DB Key

Get your Azure Cosmos DB key, get the `primaryMasterKey`

```bash
az cosmosdb list-keys -g <your-azure-group-name> -n <your-azure-COSMOSDB-name>
```

## Running Spring TODO App locally

### STEP 1 - Checkout Spring TODO app

```bash
git clone https://github.com/Microsoft/spring-todo-app.git
cd spring-todo-ap
```  
    
### STEP 2 - Configure the app

Set environment variables using a script file. Start with 
the supplied template in the repo: 

```bash
cp set-env-variables-template.sh .scripts/set-env-variables.sh
```
 
Edit .scripts/set-env-variables.sh and supply Azure 
Cosmos DB connection info. Particularly:

```bash
export COSMOS_URI=<put-your-COSMOS-DB-documentEndpoint-URI-here>
export COSMOS_KEY=<put-your-COSMOS-DB-primaryMasterKey-here>
export COSMOS_DATABASE=<put-your-COSMOS-DATABASE-name-here>
```
    
    
Set environment variables:

```bash
source .scripts/set-env-variables.sh
```

### STEP 3 - Run Spring TODO App locally

```bash
mvn package spring-boot:run
```
You can access Spring TODO App here: [http://localhost:8080/](http://localhost:8080/).

## Clean up

You can delete Azure resources that you created deleting 
the Azure Resource Group:

```bash
az group delete -y --no-wait -n <your-resource-group-name>
```

## Contributing

This project welcomes contributions and suggestions.  Most contributions require you to agree to a
Contributor License Agreement (CLA) declaring that you have the right to, and actually do, grant us
the rights to use your contribution. For details, visit https://cla.microsoft.com.

When you submit a pull request, a CLA-bot will automatically determine whether you need to provide
a CLA and decorate the PR appropriately (e.g., label, comment). Simply follow the instructions
provided by the bot. You will only need to do this once across all repos using our CLA.

This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/).
For more information see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or
contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.

## Useful link
- [Azure Spring Boot Starters](https://github.com/Microsoft/azure-spring-boot)
- [Azure for Java Developers](https://docs.microsoft.com/en-us/java/azure/)
