
<%
	String errMsg = (String) request.getAttribute("errMsg");
String msg = (String) request.getAttribute("msg");
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AdminLab Login</title>
    <style>
        .login_oueter {
            width: 360px;
            max-width: 100%;
        }

        .logo_outer {
            text-align: center;
        }

        .logo_outer img {
            width: 120px;
            margin-bottom: 40px;
        }
    </style>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous" />

    <!-- font awesome  -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
        integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous" />
</head>

<body>
<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h1 style="color: red"><%=errMsg%>
	</h1>
	<%
		}
	%>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: green;"><%=msg%>
	</h1>
	<%
		}
	%>

    <div class="container-fluid">
        <div class="row d-flex justify-content-center align-items-center m-0" style="height: 100vh;">
            <div class="login_oueter" style="position: absolute;top: 63.2px;">
                <form action="adminlablogin" method="post" autocomplete="off" class="bg-light border p-3">
                    <div class="form-row">
                        <h4 style="position: relative;left: 96px;">Admin Login</h4>
                        <div class="col-12">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="basic-addon1"><i class="fas fa-user"></i></span>
                                </div>
                                <input name="admin_email" type="email" class="input form-control" id="email"
                                    placeholder="email" aria-label="email" aria-describedby="basic-addon1" required="required"/>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="input-group mb-6">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="basic-addon1"><i class="fas fa-lock"></i></span>
                                </div>
                                <input name="admin_password" type="password" class="input form-control" id="password"
                                    placeholder="password" required="required" aria-label="password"
                                    aria-describedby="basic-addon1" />
                                <div class="input-group-append">
                                    <span class="input-group-text" onclick="password_show_hide();">
                                        <i class="fas fa-eye" id="show_eye"></i>
                                        <i class="fas fa-eye-slash d-none" id="hide_eye"></i>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="col-12">
                            <button class="btn btn-primary mx-auto d-block mt-1" type="submit" name="signin">Login</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

<script>
    function password_show_hide() {
  var x = document.getElementById("password");
  var show_eye = document.getElementById("show_eye");
  var hide_eye = document.getElementById("hide_eye");
  hide_eye.classList.remove("d-none");
  if (x.type === "password") {
    x.type = "text";
    show_eye.style.display = "none";
    hide_eye.style.display = "block";
  } else {
    x.type = "password";
    show_eye.style.display = "block";
    hide_eye.style.display = "none";
  }
}
</script>
</body>

</html>