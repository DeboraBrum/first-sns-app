# Aplicação utilizando AWS SNS
Para realizar essa aplicação, é necessário ter um Topic na Amazon SNS. 
### Pré - requisitos

#### Criando um Topic - Amazon SNS
- Entrar em Amazon SNS;
- Clicar no menu Topics;
- Clicar em Create topic;
- Selecionar o tipo;
  - No tipo FIFO, as notificações são enviadas de acordo com a ordem das requisições e no tipo Standard não. Como não iremos enviar muitas notificações, iremos usar o Standard.
- Digitar o nome;
- Clicar em Create topic. 

#### Criando Subscriptions
Para criar inscrições, clicamos no topic desejado e seguimos os passos:
-  Em Subscriptions, clicamos em Create subscription;
-  Em Protocol, selecionamos o protocolo desejado, podendo ser uma função lambda, uma fila SQS e Email;
-  Clicar em Create subscription.

### Para executar a aplicação
Para essa aplicação, é necessário configurar algumas variáveis de ambiente, com os seguintes comandos: 
```shell
code ~/.bash_profile

export AWS_ACCESS_KEY="SUA_KEY"
export AWS_SECRET_ACCESS_KEY="SEU_SECRET"
export AWS_SNS_ARN_TOPIC="ARN"

source ~/.bash_profile
```

#### rodar o comando
```shell
./build.sh
./start.sh
```
