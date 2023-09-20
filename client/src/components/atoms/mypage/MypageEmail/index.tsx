import React, { useState } from 'react';
import Input from 'components/atoms/common/Input';
import { ReactComponent as EmailIcon } from 'assets/icons/email.svg';
import { MypageEmailWrapper } from './style';

function MypageEmail() {
	const [email, setEmail] = useState('seoyj505@naver.com');

	return (
		<MypageEmailWrapper>
			<h3>이메일</h3>
			<Input type="text" value={email} setValue={setEmail} Icon={<EmailIcon />} placeholder="" disabled />
		</MypageEmailWrapper>
	);
}

export default MypageEmail;
