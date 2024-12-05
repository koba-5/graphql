import { middleware } from "../middleware";
import { MutationResolvers } from "../type/graphql";

export const updateTodoById: MutationResolvers["updateTodoById"] = (_, { input }) => {
  return middleware((todos) => {
    const targetIndex = todos.findIndex((todo) => todo.id === input.id);
    if (targetIndex === -1) throw new Error("todoが見つかりませんでした");

    todos.splice(targetIndex, 1);

    todos.push({
      id: input.id,
      title: input.title,
      content: input.content,
    });

    return input.id;
  });
};
