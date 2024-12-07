# graphql/client

## client 配下について

GraphQL のクライアントの資材を格納する

## 動作確認

1\. graphql/server を起動させる

2\. Spring を起動

```
./gradle bootRun
```

3\. Todo 一覧を取得する

```
curl -i -X GET 'http://localhost:8081/api/todos'
```

4\. Todo を追加する

```
curl -i -X POST 'http://localhost:8081/api/todo' -H 'Content-Type: application/json' -d '{"title": "タイトル", "content": "中身"}'
```
