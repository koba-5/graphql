import { ApolloServer } from "apollo-server";
import { readFileSync } from "fs";
import { resolvers } from "./resolvers";

const typeDefs = readFileSync("./src/type/schema.graphql", { encoding: "utf-8" });

const server = new ApolloServer({ typeDefs, resolvers });

server.listen().then(({ url }) => {
  console.log(`🚀  Server ready at ${url}`);
});
