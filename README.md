# Tiburcio
Ferramenta CRUD para professores

Tiburcio_CRUD, é uma ferramenta crud que busca cadastrar as principais entidades (alunos, salas, aulas, notas) presentes na vida profissional de um professor.

Veja uma demonstração do funcionamento em:
	https://www.youtube.com/watch?v=pKfI4NBMrGM&feature=youtu.be
	
Opções de funcionamento:

1- Utilizando o servidor web
	
	-Utilize o Tiburcio_CRUD_OnlineServer.jar
	
	-Certifique-se que a internet esteja ativada
	
	-Configurações de firewall podem afetar o funcionamento
	
2- Utilizando o servidor local

	-Instale o MySql Server

	-Abra o cmd
		Insira:
		cd C:\Program Files\MySQL\MySQL Server 5.6\bin 
			(aplicativo feito na versão 5.6, mude para a sua versão no nome da pasta)

		mysql -u root -p

		insira a senha fornecida durante a instalação

		Insira o conteúdo de Script.sql, comando por comando.
		
	-Importe a pasta Tiburcio_Crud para o eclipse
		
	-Provavelmente será necessario alterar a senha na Classe DBUtil no pacote DAO na linha 21, para os dados referentes a sua instalação (usuário e senha).
			
			con = DriverManager.getConnection(url, "seu usuario", "senha");




Att. Felipe Santos de Souza
	Em caso de dúvidas entrar em contato com: felipesnt13@gmail.com,
