import React from 'react';
import NowPassword from 'components/atoms/mypage/Nowpassword';
import NewPassword from 'components/atoms/mypage/NewPassword';
import { ReactComponent as PwIcon } from 'assets/icons/password.svg';
import Button from 'components/atoms/common/Button';
import { UserPasswordChangeContainer } from './style';

interface IUserPasswordChangeProps {
	onClose: () => void;
}

function UserPasswordChange({ onClose }: IUserPasswordChangeProps) {
	// const [currentPassword, setCurrentPassword] = useState('');
	// const [newPassword, setNewPassword] = useState('');

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
				{/* <NowPassword onChange={(e) => setCurrentPassword(e.target.value)} />
				<NewPassword onChange={(e) => setNewPassword(e.target.value)} /> */}
				<div className="password-input">
					<NowPassword />
				</div>
				<div className="password-input">
					<NewPassword />
				</div>
				<div className="password-button">
					<div className="button-container">
						<Button text="확인" size="full" radius="m" color="Primary" handleClick={onClose} />
						<Button text="취소" size="full" radius="m" color="Normal" handleClick={onClose} />
					</div>
				</div>
			</div>
		</UserPasswordChangeContainer>
	);
}

export default UserPasswordChange;
