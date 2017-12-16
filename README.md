This a simple spring boot based application that tries to consume GeoCode Api to Dispaly the Address along with Ltitude and Longitude.
You Can read more about the api here: https://developers.google.com/maps/documentation/geocoding/intro

To Run This Application, you need first to download the source code and update maven project and then configure mysql coneection that's meet yours, i am using the below configuration you may need to update them

spring.datasource.url = jdbc:mysql://localhost:3306/agilebis
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.password=root
spring.datasource.username=root


finally, you can use the following curl to try the app or using any rest client:

1- To Login to the app:-
--------------------------------------
curl -X POST --user 'cms_mobile:Cms_m0b!l3' -d 'grant_type=password&username=test&password=test' http://localhost:9001/agilebis/oauth/token

The Response should look like:-
---------------------------------
{"access_token":"27c1d964-fcad-470f-b32b-219c662e6099",
"token_type":"bearer",
"refresh_token":"d7fe669c-cf46-46ee-b790-a9ef39ea7e63",
"expires_in":3599,
"scope":"write"
}

You Should use the access token to call any API, so w'll use it to call api that should display the formatted Address using the following curl request:-
---------------------------------

curl -i -H "Accept: application/json" -H "Authorization: Bearer 27c1d964-fcad-470f-b32b-219c662e6099" -X GET http://localhost:9001/agilebis/api/address?address=1600+20Amphitheatre+Parkway,+MountainView,CA

The Output should look like:-
----------------------------------

{
	"formattedAddress": "Google Building 41, 1600 Amphitheatre Pkwy, Mountain View, CA 94043, USA",
	"latitude": 37.4224082,
	"longitude": -122.0856086
}

