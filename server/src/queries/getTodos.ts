import { middleware } from "../middleware";
import { QueryResolvers } from "../type/graphql";

export const getTodos: QueryResolvers["getTodos"] = () => {
  return middleware((todos) => {
    return todos;
  });
};
