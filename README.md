Todo List
====================

This is a todo list web application.
It uses Java EE with Jersey Framework.

The Application can be accessed ont the here: [http://todo-vjroby.rhcloud.com/lists](http://todo-vjroby.rhcloud.com/lists).
In order to get a single list without items: `http://todo-vjroby.rhcloud.com/lists/{list_id}`
In order to get a single list with items: `http://todo-vjroby.rhcloud.com/lists/{list_id}/items`
If a list does not have items an empty array will be delivered.

It might not work at the first request because it is a free account, please do a refresh after the first request. Rhcloud puts the app to stand-by if it is not used.


