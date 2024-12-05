import { middleware } from "../middleware";
import { QueryResolvers } from "../type/graphql";

export const getTodoById: QueryResolvers["getTodoById"] = (_, { input }) => {
  return middleware((todos) => {
    const targetTodo = todos.find((todo) => (todo.id = input.id));
    if (targetTodo === undefined) throw new Error("todoが見つかりませんでした");

    return targetTodo;
  });
};
