# server

## server 配下について

GraphQL のサーバの資材を格納する

## 動作確認

1\. node_modules のインストール

```
pnpm i
```

2\. 型生成

```
pnpm autoCreate
```

3\. 開発モードで起動

```
pnpm dev
```

4\. GetTodos を実行

```
curl -i -X POST 'http://localhost:4000/graphql' \
  -H 'content-type: application/json' \
  -d '{"query":"query GetTodos { getTodos { id, title, content } }"}'
```

5\. GetTodoById を実行

```
curl -i -X POST 'http://localhost:4000/graphql' \
  -H 'content-type: application/json' \
  -d '{"query":"query GetTodoById($input: GetTodoByIdInput!) { getTodoById(input: $input) { content, id, title }}","variables":{"input":{"id":1}}}'
```

6\. AddTodo を実行

```
curl -i -X POST 'http://localhost:4000/graphql' \
  -H 'content-type: application/json' \
  -d '{"query":"mutation AddTodo($input: AddTodoInput!) { addTodo(input: $input) }","variables":{"input":{"content":"部屋の掃除","title":"家事"}}}'
```

7\. UpdateTodo を実行

```
curl -i -X POST 'http://localhost:4000/graphql' \
  -H 'content-type: application/json' \
  -d '{"query":"mutation UpdateTodo($input: UpdateTodoInput!) { updateTodo(input: $input) }","variables":{"input":{"content":"【更新】LocalStackに対して`terraform apply`をやってみる","id":1,"title":"【更新】Terraform"}}}'
```

8\. DeleteTodo を実行

```
curl -i -X POST 'http://localhost:4000/graphql' \
  -H 'content-type: application/json' \
  -d '{"query":"mutation DeleteTodo($input: DeleteTodoInput!) { deleteTodo(input: $input) }","variables": {"input":{"id":1}}}'
```
