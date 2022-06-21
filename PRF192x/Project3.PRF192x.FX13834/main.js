$(document).ready(function() {
    /** declara  gradeList and classArray */
    let gradeList = {
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
    // append grade student
    $.each(gradeList, function(key, value) {
        $('#grade').append(`<option value="${key}">${key}</option>`);
    });
    // declaration define class when choose grade 
    $('#grade').change(function() {
        $('#class').html('');
        let classArr = gradeList[$('#grade').val()];
        $.each(classArr, function(key, value) {
            $('#class').append(`<option value="${value}">${value}</option>`);
        });
    });

    /** Import to table*/
    let count = 0;
    $('#import').click(function() {
        //Validate form
        if (($('#name').val() == '') || ($('#grade').val() == '') || ($('#class').val() == null) ||
            ($('#math').val() == '') || ($('#physic').val() == '') || ($('#chem').val() == '') ||
            isNaN($('#math').val()) || isNaN($('#physic').val()) || isNaN($('#chem').val())) {
            return confirm('Vui lòng nhập lại!');
        };

        //Append input value to result
        $('#sheet-students').append(
            `<tr>
                <td>${++count}</td>
                <td>${$('#name').val()}</td>
                <td>${$('#grade').val()}</td>
                <td>${$('#class').val()}</td>
                <td>${$('#math').val()}</td>
                <td>${$('#physic').val()}</td>
                <td>${$('#chem').val()}</td>
                <td>?</td>
            </tr>`
        );
        // Reset value of input
        $('#name').val("");
        $('#grade').val("");
        $('#class').val("");
        $('#math').val("");
        $('#physic').val("");
        $('#chem').val("");
    });

    // Define mean of score
    $('#cal-mean').click(function() {
        $('#sheet-students tr').each(function() {
            let math = $(this).children("td:nth-child(5)").text();
            let physic = $(this).children("td:nth-child(6)").text();
            let chem = $(this).children("td:nth-child(7)").text();
            let mean = (parseFloat(math) + parseFloat(physic) + parseFloat(chem)) / 3;
            $(this).children("td:nth-child(8)").text(mean.toFixed(1));
        });
    });

    // Define student Profession
    $('#cal-stupro').click(function() {
        $('#sheet-students tr').each(function() {
            if ($(this).children("td:nth-child(8)").html() >= 8.0) {
                $(this).addClass("text-danger");
            };
        });
    });
});