import { Resolvers } from "./type/graphql";
import { deleteTodoById } from "./mutations/deleteTodoById";
import { updateTodoById } from "./mutations/updateTodoById";
import { addTodo } from "./mutations/addTodo";
import { getTodos } from "./queries/getTodos";
import { getTodoById } from "./queries/getTodoById";

export const resolvers: Resolvers = {
  Query: {
    getTodos,
    getTodoById,
  },
  Mutation: {
    addTodo,
    updateTodoById,
    deleteTodoById,
  },
};
