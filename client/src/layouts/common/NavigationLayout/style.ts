import styled from 'styled-components';

export const NavigationLayoutWrapper = styled.div`
	position: fixed;
	width: 100%;
	background-color: var(--white-color);
	z-index: 50;

	.navigation-container {
		width: var(--content-width-m);
		margin: 0 auto;

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
