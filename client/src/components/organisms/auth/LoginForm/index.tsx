import React, { useState } from 'react';
import { ReactComponent as DownIcon } from 'assets/icons/down.svg';
import { ReactComponent as IdIcon } from 'assets/icons/id.svg';
import { ReactComponent as PasswordIcon } from 'assets/icons/password.svg';
import Input from 'components/atoms/common/Input';
import Button from 'components/atoms/common/Button';
import { loginApi } from 'utils/apis/auth';
import CheckTextButton from 'components/atoms/common/CheckTextButton';
import { useNavigate } from 'react-router-dom';
import { FieldSet, LoginFormContainer } from './style';

function LoginForm() {
	const [email, setEmail] = useState('');
	const [password, setPassword] = useState('');
	const [isSave, setIsSave] = useState(false);
	const navigate = useNavigate();

	const login = async () => {
		try {
			const body = {
				email,
				password,
			};
			const response = await loginApi(body);

			console.log(response);
		} catch (error) {
			console.error(error);
		}
	};

	return (
		<LoginFormContainer>
			<h2 className="login-message">지금 로그인하고 기사 추천받기</h2>
			<DownIcon />
			<FieldSet>
				<Input type="text" value={email} setValue={setEmail} placeholder="이메일 아이디" Icon={<IdIcon />} />
				<Input type="password" value={password} setValue={setPassword} placeholder="비밀번호" Icon={<PasswordIcon />} />
				<CheckTextButton value={isSave} setValue={setIsSave} text="로그인 상태 유지" />
			</FieldSet>
			<Button text="로그인" color="Primary" size="full" radius="s" handleClick={login} />
			<div>
				<button type="button">아이디 찾기</button>
				<button type="button">비밀번호 찾기</button>
				<button
					type="button"
					onClick={() => {
						navigate('/auth/join');
					}}
				>
					회원가입
				</button>
			</div>
		</LoginFormContainer>
	);
}

export default LoginForm;
