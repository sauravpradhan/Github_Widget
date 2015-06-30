Github_Widget
=============
A widget to show your recently starred repo in Github.

How it works?
=============
Currently I'm just fetching the starred repo using Github's REST for starred repo.
Anybody can modify the code to work with any REST API with JSON response(of same JSON structure).

How to setup the widget to show your stars:
=============
1)Go to -> Github_Widget/src/com/saurav/githubwidget/myWidget.java line no 38.

2)Replace "kodered" with your username without quotes.

3)Recompile the app and apply the widget and you are done.

What doesn't work:
=============
1)As you update your stars it doesn't update the widget.

2)Infact the widget itself never updates.You've to re-apply the widget to see the changes.

3)Touching the widget has no action defined now.

Will work later on:
=============
1)Making the widget github events based.

2)Authetication Oauth(Someday).

3)Starting a configuration activity for widget to take username in the beginning.

4)Updating the widget every half an hour while invoking the API again.(There are some dependencies)

5)Updating the github logo with some dynamic github events.

Directly test the APK with my starred repo link:
=============
https://www.dropbox.com/s/a21ebw7f603seus/Github_Widget.apk?dl=0
