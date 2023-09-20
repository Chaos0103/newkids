import React from 'react';
import { UserLevelWrapper } from './style';

function UserLevel() {
	return (
		<UserLevelWrapper>
			<div className="user-level-wrapper">
				<div className="user-level-image">
					<div>level 이미지</div>
				</div>
				<div className="user-level-content">
					<p>999</p>
				</div>
			</div>
		</UserLevelWrapper>
	);
}

export default UserLevel;
