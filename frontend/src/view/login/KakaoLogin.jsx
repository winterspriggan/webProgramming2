import axios from "axios";
import swal from "sweetalert";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const CLIENT_ID = "092b8dd8c678497e53440f488cc95702";
const REDIRECT_URI = "http://localhost:40040/kakao/login";

export const SocialKakao = ({ setAuthenticated, setUser }) => {
    const navigate = useNavigate();

    const handleLogin = () => {
        const kakaoURL = `/kakao/authorize?client_id=${CLIENT_ID}&redirect_uri=${REDIRECT_URI}&response_type=code`;
        navigate(kakaoURL);
    };

    React.useEffect(() => {
        const handleCode = async () => {
            const urlSearchParams = new URLSearchParams(window.location.search);
            const code = urlSearchParams.get("code");

            if (code) {
                try {
                    const response = await axios.get(`http://localhost:40040/kakao/login?code=${code}`);
                    if (response.data !== "") {
                        swal({
                            title: "로그인 성공",
                            text: "환영합니다!",
                            icon: "success",
                            button: "확인",
                        });
                        setUser({
                            id: response.data.id,
                            name: response.data.name,
                        });
                        setAuthenticated(true);
                        navigate('/');
                    }
                    console.log('백엔드에서 받은 응답:', response.data);
                } catch (error) {
                    console.error('백엔드 요청 중 오류:', error);
                }
            }
        };



        window.addEventListener("load", handleCode);

        return () => {
            window.removeEventListener("load", handleCode);
        };
    }, []);

    return (
        <>
            <button
                onClick={handleLogin}
                style={{ background: "none", border: "none", padding: 0, cursor: "pointer" }}
            >
                <img src="/kakao_login.png" />
            </button>
        </>
    );
};
