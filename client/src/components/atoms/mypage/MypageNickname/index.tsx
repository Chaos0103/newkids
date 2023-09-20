import React, { useState } from 'react';
import Input from 'components/atoms/common/Input';
import { ReactComponent as NicenameIcon } from 'assets/icons/nickname.svg';
import Button from 'components/atoms/common/Button';
import { MypageNicknameWrapper } from './style';

function MypageNickname() {
	const [nicename, setNickname] = useState('쿠쿠루삥뽕');
	const login = async () => {
		alert('경고');
	};

	return (
		<MypageNicknameWrapper>
			<h3>닉네임</h3>
			<div className="nickname-input-content">
				<Input type="text" value={nicename} setValue={setNickname} Icon={<NicenameIcon />} placeholder="" />
				<Button text="변경" radius="l" color="Success" size="s" handleClick={login} />
			</div>
		</MypageNicknameWrapper>
	);
}

export default MypageNickname;
