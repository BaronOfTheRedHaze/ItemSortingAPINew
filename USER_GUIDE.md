I denna manual har du länkar plus några exempel anropp

För att starta applicationen kommer man behöva att man runnar aplication i ditt val av IDE. 

Sedan använder man antingen Postman, Insomnia eller liknande. 


POST:
http://itemsortingapinapp.eba-v3kuj4bu.eu-north-1.elasticbeanstalk.com/create

{ 
	"name":"The Matrix"
}

{ 
	"name":"The Godfather"
}

{ 
	"name":"Dune (2022)"
}


GET(All items):
http://itemsortingapinapp.eba-v3kuj4bu.eu-north-1.elasticbeanstalk.com/listitems

[
	{
		"id": 1,
		"name": "The Matrix"
	},
	{
		"id": 2,
		"name": "The Godfather"
	},
	{
		"id": 3,
		"name": "Dune (2022)"
	}
]


GET(One item):
http://itemsortingapinapp.eba-v3kuj4bu.eu-north-1.elasticbeanstalk.com/getbyid?id=1

{
	"id": 1,
	"name": "The Matrix"
}



DELETE:
http://itemsortingapinapp.eba-v3kuj4bu.eu-north-1.elasticbeanstalk.com/removebyid?id=2

[
	{
		"id": 1,
		"name": "The Matrix"
	},
	{
		"id": 3,
		"name": "Dune (2022)"
	}
]
