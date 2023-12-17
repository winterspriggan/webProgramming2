// import axios from "axios";
// import swal from "sweetalert";
// import React from "react";
//
// const CLIENT_ID = "092b8dd8c678497e53440f488cc95702";
// const REDIRECT_URI = "http://localhost:40040/kakao/login";
//
// export const SocialKakao = () => {
//     const handleLogin = () => {
//         // 새로운 창 또는 팝업에서 Kakao 로그인 페이지로 이동
//         const kakaoURL = `https://kauth.kakao.com/oauth/authorize?client_id=${CLIENT_ID}&redirect_uri=${REDIRECT_URI}&response_type=code`;
//         const newWindow = window.open(kakaoURL, '_blank');
//
//         // Kakao OAuth 인증코드를 얻는 로직
//         const handleCode = (event) => {
//             if (event.source === newWindow) {
//                 // 팝업이 닫히면 이벤트 리스너를 제거하고 인증코드를 사용할 수 있음
//                 window.removeEventListener('message', handleCode);
//                 const code = event.data;
//                 console.log('Kakao OAuth 인증코드:', code);
//
//                 // 백엔드로 인가 코드 전송
//                 axios
//                     .get('http://localhost:40040/kakao/login', {
//                         params: {
//                             code: code
//                         },
//                     })
//                     .then(response => {
//                         if (response.data !== '')
//                             swal({
//                                 title: '로그인 성공',
//                                 text: '환영합니다, '  ,
//                                 icon: 'success',
//                                 button: '확인',
//                             })
//                         console.log('백엔드에서 받은 응답:', response.data)
//                         // 여기서 얻은 엑세스 토큰을 사용할 수 있음
//                         window.close();
//                     })
//                     .catch(error => {
//                         console.error('백엔드 요청 중 오류:', error);
//                     });
//             }
//         };
//
//         // Kakao OAuth 인증코드를 얻기 위한 이벤트 리스너 등록
//         window.addEventListener('message', handleCode);
//     };
//
//     return (
//         <>
//             <button onClick={handleLogin}>카카오 로그인</button>
//         </>
//     );
// };

import axios from "axios";
import swal from "sweetalert";
import React, {useState} from "react";

const CLIENT_ID = "092b8dd8c678497e53440f488cc95702";
const REDIRECT_URI = "http://localhost:40040/kakao/login";

export const SocialKakao = ({ setAuthenticated, setUser }) => {
    const userId  = useState('');
    const email  = useState('');
    const name  = useState('');

    const handleLogin = () => {
        const kakaoURL = `https://kauth.kakao.com/oauth/authorize?client_id=${CLIENT_ID}&redirect_uri=${REDIRECT_URI}&response_type=code`;
        window.location.href = kakaoURL;
    };

    React.useEffect(() => {

        const handleCode = async () => {
            const code = new URL(window.location.href).searchParams.get("code");
            if (code) {
                try {
                    const response = await axios.get('http://localhost:40040/kakao/login', {
                        params: {
                            id: userId,
                            email: email,
                            name: name
                        },
                    })
                .then((response) => {
                        if (response.data !== '') {
                            swal({
                                title: '로그인 성공',
                                text: '환영합니다!',
                                icon: 'success',
                                button: '확인',
                            });
                            setUser({
                                id: response.data.id,
                                name: response.data.name,
                            });
                            setAuthenticated(true);
                        }

                        console.log('백엔드에서 받은 응답:', response.data);
                    })
                } catch (error) {
                    console.error('백엔드 요청 중 오류:', error);
                }
            }
        };

        window.addEventListener('load', handleCode);

        return () => {
            window.removeEventListener('load', handleCode);
        };
    }, []);

    return (
        <>
            <button onClick={handleLogin} style={{ background: 'none', border: 'none', padding: 0, cursor: 'pointer' }}>
                <img src="/kakao_login.png" />
            </button>
        </>
    );
};
