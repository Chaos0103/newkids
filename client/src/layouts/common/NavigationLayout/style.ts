import styled from 'styled-components';

export const NavigationLayoutWrapper = styled.div`
	position: fixed;
	left: 0;
	right: 0;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	background-color: red;
	z-index: 50;

	.navigation-container {
		width: var(--content-width-m);

		.navibar {
			height: 76px;
			background-color: blue;
		}

		.menubar {
			height: 90px;
			background-color: yellow;
		}
	}
`;
