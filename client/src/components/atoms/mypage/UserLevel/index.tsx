import React from 'react';
import { UserLevelWrapper } from './style';
// import levelImage from '../../../../assets/imgs/level.png';

function UserLevel() {
	return (
		<UserLevelWrapper>
			<div className="user-level-wrapper">
				{/* <img className="user-level-image" src={levelImage} alt="level" /> */}
				{/* <div className="user-level-content"> */}
				<p className="level-title">Lv.</p>
				<p className="level-number">999</p>
				{/* </div> */}
			</div>
		</UserLevelWrapper>
	);
}

export default UserLevel;
