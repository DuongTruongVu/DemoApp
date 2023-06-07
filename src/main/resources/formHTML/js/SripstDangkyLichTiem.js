$(document).ready(function () {

    var ktTen = false;

    var ktNgaySinh = false;

    var ktSoNha = false;

    var ktHoTenNLH = false;

    var ktSDT = false;

    $('#hoten').blur(function () {

        var hoTen = $('#hoten').val();

        if (hoTen.length < 6) {

            document.getElementById("hoten").value = "";

            $("#hoten").attr("placeholder", "Họ và tên phải >= 6 ký tự");

            $("#hoten").attr("placeholder", "Họ và tên không được bỏ trống");

            $("#ihoten").attr("class", "zmdi zmdi-account material-icons-name");

            ktTen = false;

        } else {

            $("#hoten").attr("class", "zmdi zmdi-badge-check");

            ktTen = true;

        }

    });


    $('#HoTenNLH').blur(function () {

        var HoTenNLH = $('#HoTenNLH').val();

        if (ktHoTenNLH = false) {

            $("#HoTenNLH").attr("placeholder", "Ngày sinh không được bỏ trống");

            $("#HoTenNLH").attr("class", "zmdi zmdi-account material-icons-HoTenNLH");

            ktHoTenNLH = false;
        } else {
            $("#HoTenNLH").attr("class", "zmdi zmdi-badge-check");
            ktHoTenNLH = true;

        }

    });

    $('#NgaySinh').blur(function () {

        var NgaySinh = $('#NgaySinh').val();

        if (ktNgaySinh = false) {

            $("#NgaySinh").attr("placeholder", "Ngày sinh không được bỏ trống");

            $("#NgaySinh").attr("class", "zmdi zmdi-account material-icons-NgaySinh");

            ktNgaySinh = false;
        } else {
            $("#NgaySinh").attr("class", "zmdi zmdi-badge-check");
            ktNgaySinh = true;


        }

    });
    $('#SDT').blur(function () {

        var SDT = $('#SDT').val();

        if (ktSDT = false) {

            $("#SDT").attr("placeholder", "SDT không được bỏ trống");

            $("#SDT").attr("class", "zmdi zmdi-account material-icons-NgaySinh");

            ktSDT = false;
        } else {
            $("#NgaySinh").attr("class", "zmdi zmdi-badge-check");
            ktSDT = true;


        }

    });


    $("#dangky").click(function () {

        if (ktTen == false || ktNgaySinh == false || ktTinhThanh == false || ktHoTenNLH == false ||
            ktSDT == false || ktSoNha == false) {

            alert("Đăng ký thất bại vì một số trường chưa hoàn thành việc điền dữ liệu");

        } else {

            //alert(wrong text);


            $('#ketqua').html("Đăng ký thành công vui lòng check email:  <b>" + email + "</b> để xác nhận thông tin");

        }

    });

});