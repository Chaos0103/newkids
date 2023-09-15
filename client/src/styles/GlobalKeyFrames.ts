import { createGlobalStyle } from 'styled-components';

export const GlobalKeyFrames = createGlobalStyle`
    @keyframes appear-slide-y {
        from {
            transform: translateY(-100%);
        }
        to {
            transform: translateX(0%);
        }
}
    
`;
