import styled from 'styled-components';

export const NavBarContainer = styled.div<{ $auth?: boolean }>`
	z-index: 20;
	position: relative;
	background-color: var(--white-color);
	height: 100%;
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: ${({ $auth }) => ($auth ? 'center' : 'space-between')};

	.logo {
		display: flex;
		align-items: center;

		svg {
			width: 170px;
			height: 56px;
		}

		&:hover {
			cursor: pointer;
		}
	}

	.search-bar {
	}

	.member-info {
		color: var(--main-color);
		font-weight: bold;
		display: flex;
		flex-direction: row;
		align-items: center;
		transition: all 0.2s;

		svg {
			fill: var(--sub-color-1);
		}

		&:hover {
			margin-top: 10px;
		}
	}
`;
