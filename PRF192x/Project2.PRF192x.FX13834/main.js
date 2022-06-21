var nameCtrl = document.getElementById('name'); //select input name id
var gradeCtrl = document.getElementById('grade'); //select input grade id
var classCtrl = document.getElementById('class'); //select input class id
var mathCtrl = document.getElementById('math'); //select input math  id
var physicCtrl = document.getElementById('physic'); //select input physic id
var chemCtrl = document.getElementById('chem'); //select input chem id
var importBtn = document.getElementById('import'); //select Button import id
var sheetResult = document.getElementById('sheet-students'); //select sheet result table id
var meanBtn = document.getElementById('cal-mean'); // select Button mean id
var stuProBtn = document.getElementById('cal-stupro'); //select Button student profession id


importBtn.addEventListener('click', add); // Listen event click importBtn
meanBtn.addEventListener('click', calMean); // Listen event click meanBtn
stuProBtn.addEventListener('click', calStuPro); // Listen event click stuProBtn
// declaration define sample student and list student
var student = {
    name: "",
    grade: "12",
    class: "12F",
    math: 0,
    physic: 0,
    chem: 0
};
var studentArr = [];
/** declara  gradeArray and classArray */
var gradeArr = {
    "10": [
        "10A", "10B", "10C", "10D", "10E", "10F"
    ],
    "11": [
        "11A", "11B", "11C", "11D", "11E", "11F"
    ],
    "12": [
        "12A", "12B", "12C", "12D", "12E", "12F"
    ]
};

for (const key in gradeArr) {
    gradeCtrl.innerHTML += `<option value="${key}">${key}</option>`
}
gradeCtrl.addEventListener('change', changeGrade);
// declaration define classArray when choose grade 
function changeGrade() {
    classCtrl.innerHTML = '';
    var classArr = gradeArr[gradeCtrl.value];
    // for (let i = 0; i < classArr.length; i++) {
    //     classCtrl.innerHTML += `<option value="${classArr[i]}">${classArr[i]}</option>`;
    // }

    for (const value of classArr) {
        classCtrl.innerHTML += `<option value="${value}">${value}</option>`
    }
}
// Reset form
function reset() {
    nameCtrl.value = "";
    gradeCtrl.value = "";
    classCtrl.value = "";
    mathCtrl.value = "";
    physicCtrl.value = "";
    chemCtrl.value = "";
}
// GET info from form
function get() {
    student = {
        name: nameCtrl.value,
        grade: gradeCtrl.value,
        class: classCtrl.value,
        math: mathCtrl.value,
        physic: physicCtrl.value,
        chem: chemCtrl.value
    };
    studentArr.push(student);
    // Insert to table
    var row = sheetResult.insertRow(-1);
    row.insertCell(0).innerHTML = studentArr.length;
    row.insertCell(1).innerHTML = student.name;
    row.insertCell(2).innerHTML = student.grade;
    row.insertCell(3).innerHTML = student.class;
    row.insertCell(4).innerHTML = student.math;
    row.insertCell(5).innerHTML = student.physic;
    row.insertCell(6).innerHTML = student.chem;
    row.insertCell(7).innerHTML = '?';
    // row.insertCell(8).innerHTML = '<button type=""button" class="btn btn-warning" onclick="editStu(this)">Sửa</button>';
    // row.insertCell(9).innerHTML = `<button class="btn btn-danger" onclick="deleteStu(this)">Xóa</button>`;
}
// Import to table
function add() {
    get();
    reset();
}
// Define mean of score
function calMean() {
    for (var i = 0, row; row = sheetResult.rows[i]; i++) {
        student = {
            name: row.cells[1].innerHTML,
            grade: row.cells[2].innerHTML,
            class: row.cells[3].innerHTML,
            math: row.cells[4].innerHTML,
            physic: row.cells[5].innerHTML,
            chem: row.cells[6].innerHTML
        };
        student.mean = function() {
            mean = (parseFloat(student.math) + parseFloat(student.physic) + parseFloat(student.chem)) / 3
            return parseFloat(mean.toFixed(1));
        };
        row.cells[7].innerHTML = student.mean();
        // console.log(typeof student.mean());
    }
}
// Define student Profession
function calStuPro() {
    for (var i = 0, row; row = sheetResult.rows[i]; i++) {
        if (row.cells[7].innerHTML >= 8.0) {
            row.style.color = 'red';
        }
    }
}