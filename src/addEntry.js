const fs = require("fs");
const mkdirp = require("mkdirp");
const inquirer = require("inquirer");
const chalk = require("chalk");

const README_PATH = "./README.md";
const ENCODING = "utf8";


function getCamelCase(str) {
  return str
    .split(" ")
    .map((ele) => ele && ele[0].toUpperCase() + ele.substring(1, ele.length))
    .join("");
}

function generateReadmeTemplate(prob, codefilePath, docfilePath) {
  const { name, code, url, difficulty } = prob;
  const template = `| # | Title | Solution | Difficulty | Docs |\n|---| ----- | -------- | ---------- | ---- |\n|${code}|[${name}](${url})|[[Java]](${codefilePath})|${difficulty}|[[Docs]](${docfilePath})\n\n\n`;
  return template;
}

function appendToReadMe(data) {
  fs.appendFileSync(README_PATH, data, 'utf8');
}

function createDir(dirpath) {
  mkdirp.sync(dirpath);
  // console.log(`made directories, starting with ${dirpath}`);
}

function createCodeDir(dirname) {
  const dirpath = "./src/" + dirname;
  createDir(dirpath);
  return dirpath;
}

function createDocDir(dirname) {
  const dirpath = "./src/" + dirname + "Doc";
  createDir(dirpath);
  return dirpath;
}

function addEntry(prob) {
  const fileName    = getCamelCase(prob.name);
  const codeDirPath = createCodeDir(prob.type);
  const docDirPath  = createDocDir(prob.type);
  
  const codefilePath =  createFile(codeDirPath, fileName, ".java");
  const docfilePath  =  createFile(docDirPath, fileName, ".md");
  const template = generateReadmeTemplate(prob, codefilePath, docfilePath);
  appendToReadMe(template);

  console.log(chalk.green.bold("Changes saved :) "))
}

function createFile(dirPath, fileName, extension) {
  const filePath = dirPath + "/" + fileName + extension;
  // console.log(filePath);
  if(!fs.existsSync(filePath)) {
    fs.writeFileSync(filePath, "", "utf8");
  } else {
    console.log(chalk.red.bold("File Exists"));
  }
  return filePath;
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
      choices: ["array", "stack", "linkedList", "recursionOrDp"],
      default: 4,
    },
    {
      name: "problemDifficulty",
      type: "list",
      message: "What is the difficulty level of problem?",
      choices: ["Easy", "Medium", "Hard"],
      default: 3,
    },
    {
      name: "problemCode",
      type: "input",
      message: "Enter the problem Code",
    },
  ])
  .then((answers) => {
    addEntry({
      code: answers.problemCode,
      name: answers.problemName,
      url: answers.problemUrl,
      type: answers.problemType,
      difficulty: answers.problemDifficulty
    });
  })
  .catch((err) => console.log(chalk.red.bold(err)));


//  addEntry({
//    code: 134,
//    name: "Jump Game",
//    url: "https://leetcode.com/problems/jump-game/",
//    type: "recursionOrDp",
//  });