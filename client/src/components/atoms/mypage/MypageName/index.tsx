import React, { useState } from 'react';
import Input from 'components/atoms/common/Input';
import { ReactComponent as IdIcon } from 'assets/icons/id.svg';
import { MypageNameWrapper } from './style';

function MypageName() {
	const [name, setName] = useState('서용준');

	return (
		<MypageNameWrapper>
			<h3>이름</h3>
			<Input type="text" value={name} setValue={setName} Icon={<IdIcon />} placeholder="" disabled />
		</MypageNameWrapper>
	);
}

export default MypageName;
