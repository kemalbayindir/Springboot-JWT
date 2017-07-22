# Springboot-JWT
Spring boot JWT implementation

# Info
With this implementation i tried to use JWT and Spring boot simply. There are two main link;
- /auth/login  (POST)
- /api/members (GET)

# Some problems and solution i am facing
- I used Lombok for constructor and getter/setter methods of model classes. During hibernate result convertions
Lombok.@AllArgsConstructor annotation did not useful because of reflection problems. You have to create your own 
simple constructor method, or you have another solution please update me too.
- Again after integrate Lombok to project, in my case for IntelliJdea, i had to arrange Annoatation Processor settings of editor.


Step 1 : Login & Get token
---------------------------
You should first post to login class a basic LoginMember object (i used postman for this)

![alt text](https://raw.githubusercontent.com/kemalbayindir/Springboot-JWT/master/screenshots/post.png)


Step 2 : check Token & Get user data
--------------------------------------
![alt text](https://raw.githubusercontent.com/kemalbayindir/Springboot-JWT/master/screenshots/inspect.png)


Step 3 : Post token & Get data
-------------------------------
![alt text](https://raw.githubusercontent.com/kemalbayindir/Springboot-JWT/master/screenshots/get.png)


# Needed Improvement of Parts
- Unit Tests !!!
- Please use strong SECRET_KEY. For this you can use MacProvider.
