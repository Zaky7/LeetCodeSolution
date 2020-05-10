const fs = require("fs");

const README_PATH = "./README.md";
const ENCODING = "utf8";

const inquirer = require("inquirer");

function getCamelCaseFileName(str) {
  return str
    .split(" ")
    .map((ele) => ele && ele[0].toUpperCase() + ele.substring(1, ele.length))
    .join("");
}

function generateReadmeTemplate(prob) {
  const { name, code, url } = prob;
  const fileName = getCamelCaseFileName(name);
  const template = `|${code}|[${name}](${url})|[[Java]](./src/array/${fileName}.java)|Medium|[[Docs]](./src/array/${fileName}.md)`;
  console.log(template);
  return template;
}

inquirer
  .prompt([
    {
      name: "problemName",
      type: "input",
      message: "Enter the problem name",
    },
    {
      name: "problemUrl",
      type: "input",
      message: "Enter the problem Url",
    },
    {
      name: "problemType",
      type: "list",
      message: "Which type of problem it is?",
      choices: ["Array", "Stack", "LinkedList", "Recursion && Dp"],
      default: 4,
    },
    {
      name: "problemCode",
      type: "input",
      message: "Enter the problem Code",
    },
  ])
  .then((answers) => {
    generateReadmeTemplate({
      code: answers.problemCode,
      name: answers.problemName,
      url: answers.problemUrl,
      type: answers.problemType,
    });
  })
  .catch((err) => console.error(err));
