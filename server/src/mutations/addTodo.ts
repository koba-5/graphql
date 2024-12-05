import { middleware } from "../middleware";
import { MutationResolvers } from "../type/graphql";

export const addTodo: MutationResolvers["addTodo"] = (_, { input }) => {
  return middleware((todos) => {
    const id = todos.length + 1;
    todos.push({
      id,
      title: input.title,
      content: input.content,
    });
    return id;
  });
};
