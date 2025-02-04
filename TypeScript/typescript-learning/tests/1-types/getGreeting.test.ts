import { describe, it, expect } from 'vitest'
import { getGreeting } from '../../functions/1-types'

describe('getGreeting', () => {
  it('retourne une chaîne de caractères', () => {
    expect(typeof getGreeting('name')).toBe('string')
  })

  it('la valeur retournée contient "Hello " et le contenu de la variable `name`', () => {
    expect(getGreeting('name')).toBe('Hello name')
    expect(getGreeting('Human')).toBe('Hello Human')
  })
})
