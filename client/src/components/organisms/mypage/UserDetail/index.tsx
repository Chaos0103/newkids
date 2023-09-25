import React, { useState } from 'react';
import MypageName from 'components/atoms/mypage/MypageName';
import MypageNickname from 'components/atoms/mypage/MypageNickname';
import MypageEmail from 'components/atoms/mypage/MypageEmail';
import MypageAge from 'components/atoms/mypage/MypageAge';
import Button from 'components/atoms/common/Button';
import ModalComponent from 'components/organisms/common/ModalComponent';
import { UserDetailContainer } from './style';
import UserPasswordChange from '../UserPasswordChange';

function UserDetail() {
	const [newPassword, setNewPassword] = useState(false);
	const changePw = () => {
		setNewPassword(true);
	};

	const closeModal = () => {
		setNewPassword(false);
	};

	return (
		<UserDetailContainer>
			<div className="mypage-title">
				<p>내 정보</p>
				<Button text="비밀번호 변경" radius="s" color="SubFirst" size="m" handleClick={changePw} />
				{newPassword && (
					<ModalComponent onClose={() => setNewPassword(!newPassword)}>
						<UserPasswordChange onClose={closeModal} />
					</ModalComponent>
				)}
			</div>
			<hr />
			<div className="mypage-form">
				<MypageName />
				<MypageEmail />
				<MypageNickname />
				<MypageAge />
			</div>
		</UserDetailContainer>
	);
}

export default UserDetail;
