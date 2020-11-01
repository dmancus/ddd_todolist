# Helpful commands to do system tests during development
## Run the server locally
```gradle bootRun```
## Simple curl testing
```
curl --silent http://localhost:8184/actuator/health | jq

curl --silent http://localhost:8184/todo_lists | jq

curl --silent -X POST http://localhost:8184/todo_list -H "Content-Type: application/json" -d '{"name":"test List 1"}'
curl --silent -X POST http://localhost:8184/todo_list -H "Content-Type: application/json" -d '{"name":"test List 2"}'

listId=db2f0028-0935-4589-9cd0-965191464cb9
curl --silent -X POST http://localhost:8184/todo_list/${listId}/item -H "Content-Type: application/json" -d '{"itemName": "A Test Item", "itemDescription": "A first experimental item to do"}'

```