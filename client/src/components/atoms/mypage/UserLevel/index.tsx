import React, { useEffect, useState } from 'react';
import { useRecoilState } from 'recoil';
import { MemberInfoState } from 'store/auth';
import { UserLevelWrapper } from './style';
// import levelImage from '../../../../assets/imgs/level.png';

function UserLevel() {
	const [memberInfo] = useRecoilState(MemberInfoState);
	const [level, setLevel] = useState(0);

	useEffect(() => {
		if (memberInfo) {
			setLevel(memberInfo.level);
		}
	}, []);
	return (
		<UserLevelWrapper>
			<div className="user-level-wrapper">
				{/* <img className="user-level-image" src={levelImage} alt="level" /> */}
				{/* <div className="user-level-content"> */}
				<p className="level-title">Lv.</p>
				<p className="level-number">{level}</p>
				{/* </div> */}
			</div>
		</UserLevelWrapper>
	);
}

export default UserLevel;
