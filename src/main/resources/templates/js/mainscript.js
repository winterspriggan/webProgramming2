document.addEventListener("DOMContentLoaded", function () {
    const loginBtn = document.getElementById("loginBtn");
    loginBtn.addEventListener("click", function () {
        const isLoggedIn = true; // 로그인 여부에 따라 변경
        if (isLoggedIn) {
            loginBtn.innerHTML = '<i class="bi-person-fill me-1"></i> MyPage';
        } else {
            loginBtn.innerHTML = '<i class="bi-person-fill me-1"></i> Login';
        }
    });
});