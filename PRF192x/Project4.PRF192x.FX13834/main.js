'use strict';
$(document).ready(function() {
    function showResult(data) {
        $.each(data.articles, function(index, article) {
            const content = `<div class="col-12 col-md-6 col-lg-4" id="card-${index}">
                                <div class="">
                                    <div class="">
                                        <div class="card">
                                            <img class="card-img-top" src="${article.image}" alt="image">
                                            <div class="card-body">
                                                <a href="${article.url}" target="_blank">
                                                    <h3 class="card-title">${article.title}</h3> 
                                                </a>    
                                                <p class ="datetime">${article.publishedAt}</p>  
                                                <p class="card-text">${article.description}</p>  
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>`;
            $('#main').append(content);
        });
    }
    //token = 6cb822a3517c05a3938eea08b49191e9, bedc8ccf1f80409657fac159424884cd, aa8818cae01ebc12908941025aed6a97, 6cb822a3517c05a3938eea08b49191e9, 200de50fc0d7123237be55dd56322a95
    const token = 'token=bedc8ccf1f80409657fac159424884cd';

    /**  */
    fetch(`https://gnews.io/api/v4/top-headlines?&lang=en&${token}`)
        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            $("#main").append('<h2>Breaking News</h2>');
            showResult(data);
        });
    //
    fetch(`https://gnews.io/api/v4/top-headlines?topic=sports&lang=en&${token}`)
        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            $("#main").append('<h2>Sports</h2>');
            showResult(data);
        });
    //
    $('#button').click(function() {
        $('#modal1').show();
    });
    $('.btn-close:first-child').click(function() {
        $('#modal1').hide();
    });
    //
    $('#search').click(function() {
        $('#modal1').hide();

        const keywords = encodeURIComponent($('#keywords').val());
        const inAttr = encodeURIComponent($('#in').val());
        const language = encodeURIComponent($('#language').val());
        const from = new Date($('#from').val() || null).toISOString();
        const to = new Date($('#to').val() || Date()).toISOString();

        // console.log(from);
        // console.log(to);
        if ((keywords != '') && (to >= from)) {
            $('#modal2').show();
            fetch(`https://gnews.io/api/v4/search?q=${keywords}&in=${inAttr}lang=${language}&from=${from}&to=${to}&${token}`)
                .then(function(response) {
                    $('#main').empty();
                    // console.log(response);
                    return response.json();
                })
                .then(function(data) {
                    $('#modal2').hide();
                    // console.log(data);
                    showResult(data);
                });
        } else {
            alert('Lỗi nhập liệu');
        }
    });
});