import React, { useState } from 'react';
import Input from 'components/atoms/common/Input';
import { ReactComponent as AgeIcon } from 'assets/icons/age.svg';
import { MypageAgeWrapper } from './style';

function MypageAge() {
	const [age, setAge] = useState('30');

	return (
		<MypageAgeWrapper>
			<h3>나이</h3>
			<Input type="text" value={age} setValue={setAge} Icon={<AgeIcon />} placeholder="" disabled />
		</MypageAgeWrapper>
	);
}

export default MypageAge;
