import { Todo } from "./type/graphql";

let todos: Array<Todo> = [
  {
    id: 1,
    title: "Terraform",
    content: "LocalStackに対して`terraform apply`をやってみる",
  },
  {
    id: 2,
    title: "Spring AOP",
    content: "Spring AOPのサンプル実装をしてみる",
  },
  {
    id: 3,
    title: "Mybatis Generator",
    content: "Mybatis Generatorを使ってみる",
  },
];

export const middleware = <T>(fn: (data: Array<Todo>) => T): T => {
  return fn(todos);
};
