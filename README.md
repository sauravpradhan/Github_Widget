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

2)Replace "sauravpradhan" with your username without quotes.

3)Recompile the app and apply the widget and you are done.

What doesn't work:
=============
1)As you update your stars it doesn't update the widget.

2)Infact the widget itself never updates.You've to re-apply the widget to see the changes.

3)Touching the widget has no action defined now.

Will work later on:
=============
1)Making the widget github events based.(Someday)

2)Authetication Oauth(Doesnt look feasible).

3)Starting a configuration activity for widget to take username in the beginning.(Done)

4)Updating the widget every half an hour while invoking the API again.(There are some dependencies)

5)Updating the github logo with some dynamic github events.(To Do)

Directly test the APK with my starred repo link:
=============
https://drive.google.com/file/d/0Byaspar4S5SEaTRMZk55UG5DMHM/view?usp=sharing

Screen Shot:
=============
![Alt text](https://cloud.githubusercontent.com/assets/1622949/8426587/b0c8f836-1f2e-11e5-88bd-5e5b0a1346bf.png "Optional title")

