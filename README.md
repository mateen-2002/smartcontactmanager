# smartcontactmanager

**METHOD**	           **URL**                                               **DESCRIPTION**
POST	      /smartcontactmanager/signup	                              To register a user
GET	        /smartcontactmanager/users	                              To view all users
GET	        /smartcontactmanager/users/{uid}	                        To view a user with particular id
PUT	        /smartcontactmanager/users/{uid}	                        To update the given user details
POST	      /smartcontactmanager/user/{uid}/contacts	                To add contacts to the given user
GET	        /smartcontactmanager/user/{uid}/contacts	                To view all contacts of a given user
PUT	        /smartcontactmanager/user/{uid}/contacts/{cid}	          To update a particular contact of a user
GET	        /smartcontactmanager/user/{uid}/contacts/{string}	        To view contacts starting with the given string
