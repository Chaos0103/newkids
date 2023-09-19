import React from 'react';
import MypageName from 'components/atoms/mypage/MypageName';
import MypageNickname from 'components/atoms/mypage/MypageNickname';
import MypageEmail from 'components/atoms/mypage/MypageEmail';
import MypageAge from 'components/atoms/mypage/MypageAge';
import Button from 'components/atoms/common/Button';
import { UserDetailContainer } from './style';

function UserDetail() {
	const login = async () => {
		alert('경고');
	};

	return (
		<UserDetailContainer>
			<div className="mypage-title">
				<p>내 정보</p>
				<Button text="비밀번호 변경" radius="s" color="SubFirst" size="m" handleClick={login} />
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
