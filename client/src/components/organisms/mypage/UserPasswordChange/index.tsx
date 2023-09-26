import React, { useEffect, useState } from 'react';
import { ReactComponent as PwIcon } from 'assets/icons/password.svg';
import Button from 'components/atoms/common/Button';
import { patchPasswordApi } from 'utils/apis/auth';
import { useNavigate } from 'react-router-dom';
import Input from 'components/atoms/common/Input';
import { UserPasswordChangeContainer } from './style';

interface IUserPasswordChangeProps {
	onClose: () => void;
}

function UserPasswordChange({ onClose }: IUserPasswordChangeProps) {
	const [isDone, setIsDone] = useState(false);
	const [currentPwd, setcurrentPwd] = useState('');
	const [newPwd, setnewPwd] = useState('');
	const [newPwdCheck, setnewPwdCheck] = useState('');
	const navigate = useNavigate();

	const patchPassword = async () => {
		if (isDone) {
			try {
				const body = {
					currentPwd,
					newPwd,
				};
				const memberkey = localStorage.getItem('memberkey');
				if (memberkey !== null) {
					const response = await patchPasswordApi(memberkey, body);
					console.log(response);
					if (response.status === 200) {
						console.log(response);
						alert('비밀번호 변경되었습니다!');
						navigate('/auth/login');
						onClose();
					}
				}
			} catch (error) {
				console.log(error);
			}
		}
		if (!currentPwd) {
			alert('비밀번호를 입력해주세요.');
		} else if (!newPwd) {
			alert('새 비밀번호를 입력해주세요.');
		} else if (!newPwdCheck) {
			alert('새 비밀번호를 다시 입력해주세요.');
		}
	};

	useEffect(() => {
		if (currentPwd && newPwd && newPwdCheck && newPwd === newPwdCheck) {
			setIsDone(true);
		} else if (currentPwd && newPwd && newPwdCheck && newPwd !== newPwdCheck) {
			setIsDone(false);
			// alert('새 비밀번호가 일치하지 않습니다.');
		} else {
			setIsDone(false);
		}
	});

	return (
		<UserPasswordChangeContainer>
			<div className="change-password-form">
				<div className="change-password-title">
					<PwIcon />
					<h1 className="danger-color">비밀번호</h1>
					<h1 className="black-color">를&nbsp;</h1>
					<h1 className="bold-black-color">변경</h1>
					<h1 className="black-color">해주세요.</h1>
				</div>
				<div className="password-container">
					<div className="password-input">
						<Input
							type="password"
							value={currentPwd}
							setValue={setcurrentPwd}
							Icon={<PwIcon />}
							placeholder="현재 비밀번호"
						/>
						<Input type="password" value={newPwd} setValue={setnewPwd} Icon={<PwIcon />} placeholder="새 비밀번호" />
						<Input
							type="password"
							value={newPwdCheck}
							setValue={setnewPwdCheck}
							Icon={<PwIcon />}
							placeholder="새 비밀번호 확인"
						/>
					</div>
				</div>
				<div className="password-button">
					<div className="button-container">
						<Button
							text="확인"
							size="full"
							radius="m"
							color={isDone ? 'Primary' : 'Normal'}
							handleClick={patchPassword}
						/>
						<Button text="취소" size="full" radius="m" color="Normal" handleClick={onClose} />
					</div>
				</div>
			</div>
		</UserPasswordChangeContainer>
	);
}

export default UserPasswordChange;
