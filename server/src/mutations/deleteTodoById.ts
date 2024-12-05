import { middleware } from "../middleware";
import { MutationResolvers } from "../type/graphql";

export const deleteTodoById: MutationResolvers["deleteTodoById"] = (_, { input }) => {
  return middleware((todos) => {
    const targetIndex = todos.findIndex((todo) => todo.id === input.id);
    if (targetIndex === -1) throw new Error("todoが見つかりませんでした");

    todos.splice(targetIndex, 1);

    return input.id;
  });
};
