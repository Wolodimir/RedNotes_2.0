$(document).ready(function() {
    $('.line').show();
    $('.app-span').hide();
})
//app
$('.app-span').hide(); //close_app-span
//open_app
$('#menu_bt').click(function() {
    $(this).toggleClass('bt_active');
    $('.app').toggleClass('app_active');
    if ($(this).hasClass('bt_active')) {
      $('.app-span').fadeIn(100);
      $('.menu_bar').addClass('menu_active');
    }else {
        $('.app-span').fadeOut(100);
        $('.menu_bar').removeClass('menu_active');
    }
})
//close_menu
$('.container').hide();
function closeApp() {
    $('.container').hide();
    $('.app-span').fadeOut(100);
    $('.menu_bar').removeClass('menu_active');
    $('#menu_bt').removeClass('bt_active');
    $('.app').toggleClass('app_active');
}
//open_menu
$('.app-span').click(function() {
    //open_create_menu
    if ($(this).hasClass('create')) {
        closeApp();
        $('.create').show();
        $('.form_edit').hide();
    }
    //open_line_menu
    if ($(this).hasClass('line')) {
        closeApp();
        $('.line').show();
        //open_personal_line
        $('.line-note-box').hide();
        $('.line_bt').removeClass('bt_active');
        $('.pers').addClass('bt_active');
        $('.personal').show();
        $('.form_edit').hide();
    }
    //open_account_menu
    if ($(this).hasClass('acc')) {
        closeApp();
        $('.acc').show();
        $('.form_edit').hide();
    }
    //open_settings_menu
    if ($(this).hasClass('set')) {
        closeApp();
        $('.set').show();
        $('.form_edit').hide();
    }
    //open_reference_menu
    if ($(this).hasClass('ref')) {
        closeApp();
        $('.ref').show();
        $('.form_edit').hide();
    }
    //open_developers_menu
    if ($(this).hasClass('dev')) {
        closeApp();
        $('.dev').show();
        $('.form_edit').hide();
    }
})

//menu
//create
$
$('#pub').change(function() {
    if (this.checked == true) {
      $('#pub_l').addClass('bt_checked');
      $('#switch').text('☁');
    }else {
        $('#pub_l').removeClass('bt_checked');
        $('#switch').text('⚑');
    }
})
//delete_text
$('#del').click(() => {
    $('#text').val('');
})

//line 
$('.line-note-box').hide();
$('.line_bt').click(function() {
    //close_all_note-box
    $('.line-note-box').hide();
    //open_personal
    if ($(this).hasClass('pers')) {
        $('.line_bt').removeClass('bt_active');
        $('.pers').addClass('bt_active');
        $('.personal').show();
    }
    //open_global
    if ($(this).hasClass('glob')) {
        $('.line_bt').removeClass('bt_active');
        $('.glob').addClass('bt_active');
        $('.global').show();
    }
})
//counter_notes
$('#counter_pers').html($('.pers_note').length);
$('#counter_glob').html($('.global_note').length);

//dark_theme
$("#dark").change(function() {
    if (this.checked) {
        $('#theme').html('Dark Theme');
    }else {
        $('#theme').html('Light Theme');
    }
    $('body').toggleClass('body_dark', this.checked);
    $('.header-logo').toggleClass('header_logo_dark', this.checked);
    $('.container, .main').toggleClass('container_dark', this.checked);
    $('.create').toggleClass('create_dark', this.checked);
    $('.line').toggleClass('line_dark', this.checked);
    $('.acc').toggleClass('acc_dark', this.checked);
    $('.set').toggleClass('set_dark', this.checked);
    $('.ref').toggleClass('ref_dark', this.checked);
    $('.dev').toggleClass('dev_dark', this.checked);
    $('.app').toggleClass('app_dark', this.checked);
})
