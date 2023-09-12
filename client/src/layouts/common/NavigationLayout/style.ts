import styled from 'styled-components';

export const NavigationLayoutWrapper = styled.div`
	box-shadow: 0 3px 30px 0 rgba(0, 0, 0, 0.03);
	position: fixed;
	width: 100%;
	background-color: var(--white-color);
	z-index: 50;

	.navigation-container {
		width: var(--content-width-l);
		margin: 0 auto;

		.navibar {
			height: 76px;
		}

		.menubar {
			height: 90px;
		}
	}
`;
